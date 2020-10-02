package me.sombrero.code_coverage;

public class Moim {

    int maxNumberOfAttendees;

    int numberOfEnrollment;

    public boolean isEnrollmentFull(){
        if(maxNumberOfAttendees == 0) {
            return false;
        }

        if(numberOfEnrollment < maxNumberOfAttendees) {
            return false;
        }

        return true;
    }

}
