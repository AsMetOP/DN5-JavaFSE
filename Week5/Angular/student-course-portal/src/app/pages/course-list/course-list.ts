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
  searchTerm = '';

  constructor(
    private courseService: CourseService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.allCourses = this.courseService.getCourses();
    this.courses = this.allCourses;

    const search = this.route.snapshot.queryParamMap.get('search');
    if (search) {
      this.searchTerm = search;
      this.applyFilter();
    }

    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  onSearchChange() {
    this.router.navigate(['courses'], { queryParams: { search: this.searchTerm || null } });
    this.applyFilter();
  }

  applyFilter() {
    const term = this.searchTerm.toLowerCase();
    this.courses = this.allCourses.filter(c => c.name.toLowerCase().includes(term));
  }

  trackByCourseId(index: number, course: any) {
    return course.id;
  }
}