import { createAction, props } from '@ngrx/store';

export const enrollInCourse = createAction(
  '[Enrollment] Enroll In Course',
  props<{ courseId: number | string }>()
);

export const unenrollFromCourse = createAction(
  '[Enrollment] Unenroll From Course',
  props<{ courseId: number | string }>()
);

export const setEnrolledCourses = createAction(
  '[Enrollment] Set Enrolled Courses',
  props<{ courseIds: (number | string)[] }>()
);