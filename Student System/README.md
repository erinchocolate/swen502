# Student System

![StudentSystem](https://github.com/erinchocolate/swen502/blob/master/Student%20System/StudentSystem.gif)

This program is an administration system for a university. It needs to track which students are in which courses, and what their grades were for courses they have completed. The user needs to be able to look up:

- Students by name
- Students by student ID number (a number between 1000000 and 4000000)
- Courses by course code ("SWEN501")

When looking at a student, the user should be able to see:

- The grades the student received in all courses they have completed
- A list of all courses the student is currently enrolled in (those which do not yet have grades)

When looking at a course, the user should be able to see:

- How many students are in the course
- All students currently enrolled in the course
- The grades given to all students who have completed the course

They should also be able to:

- Create a new course in the system
- Add a new student to the system, with a unique name and ID number
- Enroll a student into a course
- Assign a grade to a student in a course
- Unenroll a student from a course
