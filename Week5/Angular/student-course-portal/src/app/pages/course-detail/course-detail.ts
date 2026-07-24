import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { CourseService } from '../../services/course';
import { EnrollmentService } from '../../services/enrollment';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-detail',
  imports: [CommonModule],
  templateUrl: './course-detail.html',
  styleUrl: './course-detail.css',
})
export class CourseDetail implements OnInit {
  course: Course | undefined;
  enrolledStudents$!: Observable<any[]>;

  constructor(
    private route: ActivatedRoute,
    private courseService: CourseService,
    private enrollmentService: EnrollmentService
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.courseService.getCourseById(id).subscribe({
        next: (course) => this.course = course,
        error: () => this.course = undefined
      });

      // switchMap chains the course id into a second HTTP call (enrolled students).
      // If the route param changes before the first request completes, switchMap
      // cancels the stale inner Observable and switches to the new one — this
      // prevents out-of-order responses when navigating quickly between courses.
      this.enrolledStudents$ = this.route.paramMap.pipe(
        switchMap(params => {
          const courseId = params.get('id');
          return this.enrollmentService.getStudentsByCourse(courseId!);
        })
      );
    }
  }
}