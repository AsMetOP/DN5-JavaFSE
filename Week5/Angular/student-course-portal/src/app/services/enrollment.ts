import { Injectable } from '@angular/core';
import { CourseService } from './course';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  private enrolledCourseIds: (number | string)[] = [];

  constructor(private courseService: CourseService) {}

  enroll(courseId: number | string): void {
    if (!this.enrolledCourseIds.includes(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number | string): void {
    this.enrolledCourseIds = this.enrolledCourseIds.filter(id => id !== courseId);
  }

  isEnrolled(courseId: number | string): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourses(): Course[] {
    // NOTE: getCourseById now returns an Observable (HTTP call), so this
    // synchronous method no longer works as-is. We'll need to refactor
    // this once we get to Task 2 - for now, return an empty array to
    // keep the app compiling.
    return [];
  }
}