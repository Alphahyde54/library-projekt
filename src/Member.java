public class Member implements Comparable<Member> {
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

    @Override
    public int compareTo (Member other){
        return Integer.compare(memberNumber, other.memberNumber);
    }
}
