public class Train {
    int nTotSeats;
    int nFirstClassSeats;
    int nSecondClassSeats;
    int nFirstClassReservedSeats;
    int nSecondClassReservedSeats;

    void build (int nFirstClassSeats, int nSecondClassSeats){
        this.nTotSeats = nFirstClassSeats + nSecondClassSeats;
        this.nFirstClassSeats = nFirstClassSeats;
        this.nSecondClassSeats = nSecondClassSeats;
        this.nFirstClassReservedSeats = 0;
        this.nSecondClassReservedSeats = 0;
    }

    void reserveFirstClassSeats(int ReservedSeats) {
        this.nFirstClassReservedSeats = ReservedSeats;
    }

    void reserveSecondClassSeats(int ReservedSeats) {
        this.nSecondClassReservedSeats = ReservedSeats;
    }

    double getTotOccupancyRatio(){
        return (this.nFirstClassReservedSeats + this.nSecondClassReservedSeats) * 100 / this.nTotSeats;
    }

    double getFirstClassOccupancyRatio(){
        return this.nFirstClassReservedSeats * 100 / this.nFirstClassSeats;
    }

    double getSecondClassOccupancyRatio(){
        return this.nSecondClassReservedSeats * 100 / this.nSecondClassSeats ;       
    }

    void deleteAllReservations(){
        this.nFirstClassReservedSeats = 0;
        this.nSecondClassReservedSeats = 0;
    }
}
