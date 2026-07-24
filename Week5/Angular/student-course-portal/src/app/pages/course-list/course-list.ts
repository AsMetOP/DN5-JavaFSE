import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { CourseCard } from '../../components/course-card/course-card';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, FormsModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {
  allCourses: Course[] = [];
  courses: Course[] = [];
  isLoading = true;
  errorMessage = '';
  searchTerm = '';
  newCourseName = '';

  constructor(
    private courseService: CourseService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.loadCourses();
  }

  loadCourses() {
    this.isLoading = true;
    this.courseService.getCourses().subscribe({
      next: (courses) => {
        this.allCourses = courses;
        this.courses = courses;

        const search = this.route.snapshot.queryParamMap.get('search');
        if (search) {
          this.searchTerm = search;
          this.applyFilter();
        }
      },
      error: (err) => {
        this.errorMessage = err.message || 'Failed to load courses. Please try again.';
        this.isLoading = false;
      },
      complete: () => {
        this.isLoading = false;
      }
    });
  }

  onSearchChange() {
    this.router.navigate(['courses'], { queryParams: { search: this.searchTerm || null } });
    this.applyFilter();
  }

  applyFilter() {
    const term = this.searchTerm.toLowerCase();
    this.courses = this.allCourses.filter(c => c.name.toLowerCase().includes(term));
  }

  addNewCourse() {
    if (!this.newCourseName.trim()) return;
    this.courseService.createCourse({
      name: this.newCourseName,
      code: 'NEW101',
      credits: 3,
      gradeStatus: 'pending'
    }).subscribe({
      next: () => {
        this.newCourseName = '';
        this.loadCourses();
      },
      error: (err) => {
        this.errorMessage = 'Failed to add course.';
      }
    });
  }

  deleteCourse(id: number | string) {
    this.courseService.deleteCourse(id).subscribe({
      next: () => this.loadCourses(),
      error: () => this.errorMessage = 'Failed to delete course.'
    });
  }

  trackByCourseId(index: number, course: any) {
    return course.id;
  }
}