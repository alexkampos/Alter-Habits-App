export default function filterReservationsDates(reservations){

    let allReservationsFilteredArray = [[],[],[],[],[],[],[]];
    
    const day1 = new Date();
    const day2 = new Date();
    day2.setDate(new Date().getDate()+1);
    const day3 = new Date();
    day3.setDate(new Date().getDate()+2);
    const day4 = new Date();
    day4.setDate(new Date().getDate()+3);
    const day5 = new Date();
    day5.setDate(new Date().getDate()+4);
    const day6 = new Date();
    day6.setDate(new Date().getDate()+5);
    const day7 = new Date();
    day7.setDate(new Date().getDate()+6);

    reservations.forEach(reservation => {
        if(reservation.reservationDate.toLocaleDateString() === day1.toLocaleDateString()){
            allReservationsFilteredArray[0].push(reservation);
        }else if(reservation.reservationDate.toLocaleDateString() === day2.toLocaleDateString()){
            allReservationsFilteredArray[1].push(reservation);
        }else if(reservation.reservationDate.toLocaleDateString() === day3.toLocaleDateString()){
            allReservationsFilteredArray[2].push(reservation);
        }else if(reservation.reservationDate.toLocaleDateString() === day4.toLocaleDateString()){
            allReservationsFilteredArray[3].push(reservation);
        }else if(reservation.reservationDate.toLocaleDateString() === day5.toLocaleDateString()){
            allReservationsFilteredArray[4].push(reservation);
        }else if(reservation.reservationDate.toLocaleDateString() === day6.toLocaleDateString()){
            allReservationsFilteredArray[5].push(reservation);
        }else if(reservation.reservationDate.toLocaleDateString() === day7.toLocaleDateString()){
            allReservationsFilteredArray[6].push(reservation);
        }
    })

    return allReservationsFilteredArray;
}