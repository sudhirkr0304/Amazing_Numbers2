class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        // implement me

        minutes++;
        hours += (minutes / 60);
        minutes %= 60;
        if(hours > 12) {
            hours = 1;
        }



    }
}