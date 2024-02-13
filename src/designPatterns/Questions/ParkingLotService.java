package designPatterns.Questions;


/**
 * Requirements:
 * 1. Parking lots: 10k lots
 * 2. Enter/Exits : 4
 * 3. Tickets
 * 4. Parking lot should be nearest to the entry
 * 5. Limit of the parking lot
 * 6. Types of parking spots
 * 7. Payment cash or credit cards
 * 8. Monitoring/alerting service
 *
 * Design patterns:
 * 1. Creational
 * 2. Structural
 * 3. Behavioural
 *
 * Design approach:- top-down, bottom-up
 *
 * Usecase diagram:
 * 1. Actors:
 *  - parking lot service
 *  - entry/exit
 *  - parking spot
 *  - ticket
 *  - monitoring system
 *
 *  Heaps - 4 (k terminals)
 *  Available Set
 *  Reversed Set
 *
 *  K log(n)
 *
 *
 *  POST localhost:8080/parking-service/v1/public/parking-spots
 *  GET  localhost:8080/parking-service/v1/public/parking-spots/status?vehicleType=Compact
 *
 *  POST localhost:8080/parking-service/v1/public/parking-spots/tickets
 *  GET localhost:8080/parking-service/v1/public/parking-spots/tickets/ticketId
 *  PATCH localhost:8080/parking-service/v1/public/parking-spots/tickets/ticketId
 *
 *  PATCH localhost:8080/parking-service/v1/public/parking-spots/spotId
 *
 *
 *  Tables:
 *  parking-spot
 *  spotId, vehicleId, userId, ticketId
 *
 *  ticket
 *  ticketId, userId, timestamp
 *
 *  Customer:
 *  id, mobile, name, employer
 *
 *  Vehicle:
 *  customer_id(FK), vehicle_number(PK), vehicle_type
 *
 *  Parking_slot_reservations:
 *  id, cust_id, timestamp, parking_slot_id
 *
 *  Parking_Slips:
 *  Parking_slot_reservation_id, price, actual_entry, actual_exit
 *
 *
 *  Parking_slot:
 *  id, floor_id, slot_number, wing_code
 *
 *  floor:
 *  id, block_id, height, number_of_slots
 *
 *  block:
 *  id, parking_slot
 *
 *  parking_lot:
 *  id, number_of_blocks, is_slot_available, address, isValet_Parking_available
 *
 * */



public class ParkingLotService {

    public static void main(String args[]) {

    }
}
