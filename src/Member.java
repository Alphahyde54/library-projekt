public class Member {
    final String navn;
    final int memberNumber;


    public Member(String navn, int memberNumber){
        this.navn = navn;
        this.memberNumber = memberNumber;
    }

    public int getID(){
        return memberNumber;
    }

    public String getNavn() {
        return navn;
    }

    public String toString(){
        return String.format("Navn: %s - Lånenummer:(%d)",navn, memberNumber);
    }
}
