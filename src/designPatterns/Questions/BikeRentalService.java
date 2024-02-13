package designPatterns.Questions;


/**
 * Requirements:
 * 1. User
 * 2. Vehicle
 * 3. Reservation
 * 4. Payment
 * 5. Notification
 *
 *
 * Schema:
 *
 * payment_table
 * id, card_details, status
 *
 *
 * user_table
 * id, user_name, type
 *
 *location_table
 * id, city, state
 *
 * booking_table
 * id, loc_id_state, loc_id_end, vehicle_id, user_id, start_time, end_time, status, payment_id
 *
 * vehicle_table
 * id, location_id, branch_id, vehicle_type, status, price_id
 *
 * price_table
 * id, price, surge_price
 *
 *
 * location
 *
 * */

abstract class Vehicle{

}

enum status {

}

class Location{

}

abstract class User{

}

//class VehicleReservationService{
//    List<Vehicle> vehicles
//    Map<Location, Vehicle>
//
//    getCarLocation();
//    getCarByType();
//    bookCar();
//
//}
//
//class Reserve{
//    User user;
//    Car car;
//    Location pickup;
//    Location drop;
//    int rentalPrice;
//}
//


public class BikeRentalService {

    public static void main(String[] args){

    }
}
