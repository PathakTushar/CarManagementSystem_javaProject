class Bstudent{
    protected int rollNo;
    protected String fName;
    protected String lName;

    public Bstudent(int rollNo, String fName, String lName) {
        this.rollNo = rollNo;
        this.fName = fName;
        this.lName = lName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString()
    {
        return this.rollNo+" : "+this.fName+" : "+this.lName;
    }
}
abstract class StudentRecords{
    Bstudent[] bstudent =new Bstudent[5];
    int bstudentIndex=0;

    public void addStudent(Bstudent s)
    {
        bstudent[bstudentIndex++]=s;
    }
    abstract Bstudent searchByFname(String fname);
    abstract Bstudent searchByLname(String lname);

    static void printStudentRecords(Bstudent bstudent[]){

        for(int i=0;i< bstudent.length;i++){
            System.out.println(bstudent[i]);
        }
    }

}
class SimpleSortStudentRecords extends StudentRecords{
    public Bstudent[] sortedFname;
    public Bstudent[] sortedLname;

    public void prepareSortedArrays()
    {
        this.sortedFname=bstudent.clone();
        this.sortedLname=bstudent.clone();
        sortByFname(this.sortedFname);
        sortByLname(this.sortedLname);
    }

    public static void sortByFname(Bstudent studentArray[])
    {
        for(int j=0;j<studentArray.length-1;j++)
        {
            int min=j;
            for(int k=j+1;k<studentArray.length;k++) {
                if (studentArray[k].fName.compareTo(studentArray[min].fName) < 0) {
                    min = k;
                }
            }
            Bstudent temp=studentArray[j];
            studentArray[j]=studentArray[min];
            studentArray[min]=temp;

        }
    }
    public static void sortByLname(Bstudent studentArray[])
    {
        for(int j=0;j<studentArray.length-1;j++)
        {
            int min=j;
            for(int k=j+1;k<studentArray.length;k++) {
                if (studentArray[k].lName.compareTo(studentArray[min].lName) < 0) {
                    min = k;
                }
            }
            Bstudent temp=studentArray[j];
            studentArray[j]=studentArray[min];
            studentArray[min]=temp;

        }
    }
    @Override
    Bstudent searchByFname(String fname)
    {
        Bstudent res=null;
        int low=0;
        int high=sortedFname.length;

        while (low<=high){
            int mid= low+(high-low)/2;
            if (sortedFname[mid].fName.compareTo(fname)<0)  low=mid+1;
            else if (sortedFname[mid].fName.compareTo(fname)>0)  high=mid-1;
            else {
                res=sortedFname[mid];
                break;
            }

        }
        return res;

    }

    @Override
    Bstudent searchByLname(String lname) {
        Bstudent res=null;
        int low=0;
        int high=sortedLname.length;

        while (low<=high){
            int mid= low+(high-low)/2;
            if (sortedLname[mid].lName.compareTo(lname)<0)  low=mid+1;
            else if (sortedLname[mid].lName.compareTo(lname)>0)  high=mid-1;
            else {
                res=sortedLname[mid];
                break;
            }

        }
        return res;
    }

}

public class practice {
    public static void main(String[] args) {

        Bstudent a= new Bstudent(1,"aman","pandey");
        Bstudent b= new Bstudent(2,"tushar","mishra");
        Bstudent c= new Bstudent(3,"gaurav","anand");
        Bstudent d= new Bstudent(4,"lakshay","yadav");
        Bstudent e= new Bstudent(5,"pinku","rai");

        SimpleSortStudentRecords simpleSortStudentRecords=new SimpleSortStudentRecords();
        simpleSortStudentRecords.addStudent(a);
        simpleSortStudentRecords.addStudent(b);
        simpleSortStudentRecords.addStudent(c);
        simpleSortStudentRecords.addStudent(d);
        simpleSortStudentRecords.addStudent(e);

        simpleSortStudentRecords.prepareSortedArrays();
//        System.out.println(simpleSortStudentRecords.bstudent);
//        System.out.println(simpleSortStudentRecords.sortedFname);
//        System.out.println(simpleSortStudentRecords.sortedLname);
//


        StudentRecords.printStudentRecords(simpleSortStudentRecords.bstudent);
        System.out.println();
        StudentRecords.printStudentRecords(simpleSortStudentRecords.sortedFname);
        System.out.println();
        StudentRecords.printStudentRecords(simpleSortStudentRecords.sortedLname);
        System.out.println();

//        StudentRecords.printStudentRecords(simpleSortStudentRecords.searchByFname("tushar"));

        System.out.println(simpleSortStudentRecords.searchByFname("tushar"));
        System.out.println(simpleSortStudentRecords.searchByFname("alkesh"));
        System.out.println(simpleSortStudentRecords.searchByLname("rai"));
        System.out.println(simpleSortStudentRecords.searchByLname("tiwari"));


    }
}
