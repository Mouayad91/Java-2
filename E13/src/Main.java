/*public class Main {

  public  static  void main(String[] args) {
    Uhrzeit u = new Uhrzeit(1, 1);
    System.out.println(u.getZeit());
    Raum raum = new Raum(2, 4, 6);
    Reservierung reservierung1 = new Reservierung(new Uhrzeit(8,0), new Uhrzeit(9,42));
    Reservierung reservierung2 = new Reservierung(new Uhrzeit(10,0), new Uhrzeit(10,30));
    Reservierung reservierung3 = new Reservierung(new Uhrzeit(11,12), new Uhrzeit(11,50));
    Reservierung reservierung4 = new Reservierung(new Uhrzeit(12,30), new Uhrzeit(12,59));
    Reservierung reservierung5 = new Reservierung(new Uhrzeit(13,49), new Uhrzeit(14,6));
    Reservierung reservierung6 = new Reservierung(new Uhrzeit(8,12), new Uhrzeit(9,30));
    // falls r zwichen eine resiervierte zeit => nicht möglich     Reservierung reservierung6 = new Reservierung(new Uhrzeit(8,12), new Uhrzeit(9,30));
    // falls r.b nach dem Beginn einer resvierten zeit und r.e nach dem Ende einer resvierten zeit => nicht möglich     Reservierung reservierung6 = new Reservierung(new Uhrzeit(8,12), new Uhrzeit(9,45));
    // falls r.b vor dem Beginn einer resvierten zeit und r.e nach der beginn der resvierten zeit => nicht möglich      Reservierung reservierung6 = new Reservierung(new Uhrzeit(7,0), new Uhrzeit(8,30));
    // falls r.b vor dem Ende einer resvierten zeit und r.e genau am Beginn einer nächste resvierten Zeit = > nicht möglich  Reservierung reservierung6 = new Reservierung(new Uhrzeit(9,41), new Uhrzeit(10,0));

    raum.addReservierung(reservierung1);
    raum.addReservierung(reservierung2);
    raum.addReservierung(reservierung3);
    raum.addReservierung(reservierung4);
    raum.addReservierung(reservierung5);
    //raum.addReservierung(reservierung6);

    Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
    Mitarbeiter m2 = new Mitarbeiter("John", "Doe", "john@htwsaar.de");
    Raum r1 = new Raum(18,0,1);
    Raum r2 = new Raum(2,1,9);
    Raum r3 = new Raum(2,1,10);

    m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
    m1.reserviere(r2, new Uhrzeit(14, 30), new Uhrzeit(16, 30), "WebTech");
    m2.reserviere(r2, new Uhrzeit(12, 30), new Uhrzeit(13, 30), "Prog II");
    m2.reserviere(r3, new Uhrzeit(9, 30), new Uhrzeit(11,30), "ITM");

    System.out.println(r1);
    System.out.println(r2);
    System.out.println(r3);

  }
}*/
