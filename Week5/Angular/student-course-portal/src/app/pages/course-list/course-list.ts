import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable, combineLatest, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';
import { CourseCard } from '../../components/course-card/course-card';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses, selectCoursesLoading, selectCoursesError } from '../../store/course/course.selectors';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, FormsModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {
  courses$: Observable<Course[]>;
  isLoading$: Observable<boolean>;
  errorMessage$: Observable<string | null>;
  filteredCourses$!: Observable<Course[]>;

  searchTerm = '';
  newCourseName = '';
  private searchTermValue$ = new BehaviorSubject<string>('');

  constructor(
    private store: Store,
    private courseService: CourseService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.courses$ = this.store.select(selectAllCourses);
    this.isLoading$ = this.store.select(selectCoursesLoading);
    this.errorMessage$ = this.store.select(selectCoursesError);
  }

  ngOnInit() {
    const search = this.route.snapshot.queryParamMap.get('search');
    if (search) {
      this.searchTerm = search;
    }
    this.searchTermValue$.next(this.searchTerm);

    this.filteredCourses$ = combineLatest([this.courses$, this.searchTermValue$]).pipe(
      map(([courses, term]) =>
        courses.filter(c => c.name.toLowerCase().includes(term.toLowerCase()))
      )
    );

    this.store.dispatch(loadCourses());
  }

  onSearchChange() {
    this.router.navigate(['courses'], { queryParams: { search: this.searchTerm || null } });
    this.searchTermValue$.next(this.searchTerm);
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
        this.store.dispatch(loadCourses());
      },
      error: () => {}
    });
  }

  deleteCourse(id: number | string) {
    this.courseService.deleteCourse(id).subscribe({
      next: () => this.store.dispatch(loadCourses()),
      error: () => {}
    });
  }

  trackByCourseId(index: number, course: any) {
    return course.id;
  }
}