import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, forkJoin, of } from 'rxjs';
import { switchMap, map } from 'rxjs/operators';
import { CourseService } from './course';
import { Course } from '../models/course.model';

interface Enrollment {
  id: string;
  studentId: string;
  courseId: string;
}

interface Student {
  id: string;
  name: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  private enrolledCourseIds: (number | string)[] = [];
  private apiUrl = 'http://localhost:3000';

  constructor(
    private courseService: CourseService,
    private http: HttpClient
  ) {}

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

  getEnrolledCourses(): Observable<Course[]> {
    if (this.enrolledCourseIds.length === 0) {
      return of([]);
    }
    // forkJoin runs all getCourseById calls in parallel and emits once
    // every one of them has completed, combining the results into an array.
    const requests = this.enrolledCourseIds.map(id => this.courseService.getCourseById(id));
    return forkJoin(requests);
  }

    getStudentsByCourse(courseId: number | string): Observable<Student[]> {
    // NOTE: JSON Server 1.0.0-beta.15 has a known bug where query-string
    // filtering (?courseId=X) doesn't reliably work, so we fetch all
    // enrollments and filter client-side instead.
    return this.http.get<Enrollment[]>(`${this.apiUrl}/enrollments`).pipe(
      switchMap(allEnrollments => {
        const matching = allEnrollments.filter(e => String(e.courseId) === String(courseId));
        if (matching.length === 0) {
          return of([]);
        }
        const studentRequests = matching.map(e =>
          this.http.get<Student>(`${this.apiUrl}/students/${e.studentId}`)
        );
        return forkJoin(studentRequests);
      })
    );
  }
}