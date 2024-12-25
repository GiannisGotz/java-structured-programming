package jcp;

/**
 * App where you can book and cancel seat in theater
 */
public class TheaterTicketManagement {
    //Declaring a theater with 30 rows and 12 columns seats.
    private boolean[][] theater = new boolean[30][12];

    /**
     * Books an available seat
     * if seat is already booked or seat doesn't exist,
     * it shows error message.
     *
     * @param column the column character (A-L)
     * @param row the row number (1-30)
     * @return true if the booking was successful, false otherwise
     */
    public boolean book (char column, int row) {
        int columnIndex = column - 'A';
        int rowIndex = row - 1;

        // Checking valid seat boundaries
        if ( columnIndex < 0 || columnIndex >= 12 || rowIndex < 0 || rowIndex >= 30 ) {
            System.out.println("Invalid seat");
            return false;
        }  else if (theater[rowIndex][columnIndex]) {
            System.out.println("Seat " + column + row + " is already booked");
            return false;
            } else {
            theater[rowIndex][columnIndex] = true;
            System.out.println("Seat " + column + row + " has been successfully booked!");
            return true;
        }
    }

    /**
     * Cancel a booked seat.
     * if seat is not booked or doesn't exist,
     *  it shows error message.
     * @param column the column character (A-L)
     * @param row the row number (1-30)
     * @return true if the cancellation was successful, false otherwise
     */
    public boolean cancel (char column, int row) {
        int columnIndex = column - 'A';
        int rowIndex = row - 1;


         // Checking valid seat boundaries
        if ( columnIndex < 0 || columnIndex >= 12 || rowIndex < 0 || rowIndex >= 30 ) {
            System.out.println("Invalid seat");
            return false;
        }  else if (!theater[rowIndex][columnIndex]) {
            System.out.println("Seat " + column + row + "  is not booked");
            return false;
        } else {
            theater[rowIndex][columnIndex] = false;
            System.out.println("Seat " + column + row + " has been successfully cancelled!");
            return true;
        }
    }

    public static void main(String[] args) {
                TheaterTicketManagement theaterTicketManagement = new TheaterTicketManagement();

                // Testing methods with different scenarios
                theaterTicketManagement.book('Z',12); // Invalid seat
                theaterTicketManagement.book('B',10); // Booking a valid seat
                theaterTicketManagement.book('B',10); // Trying to book the same seat again
                theaterTicketManagement.cancel('B',2);  // Trying to cancel a non-booked seat
                theaterTicketManagement.cancel('B',10); // Cancelling a booked seat
            }
    }
