public class Member {
    final String navn;
    final int memberNumber;
    private final LoanPolicy bibliotek;


    public Member(String navn, int memberNumber, LoanPolicy bibliotek){
        this.navn = navn;
        this.memberNumber = memberNumber;
        this.bibliotek = bibliotek;
    }

    public int getID(){
        return memberNumber;
    }

    public LoanPolicy getBibliotek() {
        return bibliotek;
    }

    public String getNavn() {
        return navn;
    }

    public String toString(){
        return String.format("Navn: %s - Lånenummer:(%d)",navn, memberNumber);
    }
}
