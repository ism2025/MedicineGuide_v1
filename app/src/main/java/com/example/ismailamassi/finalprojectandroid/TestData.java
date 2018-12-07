package com.example.ismailamassi.finalprojectandroid;

import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.Models.DoctorUser;
import com.example.ismailamassi.finalprojectandroid.Models.FoundationUser;
import com.example.ismailamassi.finalprojectandroid.Models.Medicine;
import com.example.ismailamassi.finalprojectandroid.Models.MedicineDepartment;
import com.example.ismailamassi.finalprojectandroid.Models.MedicineGroup;
import com.example.ismailamassi.finalprojectandroid.Models.PatientUser;
import com.example.ismailamassi.finalprojectandroid.Models.StudentUser;

import java.util.Date;

public class TestData {
    public static void GenerateData() {
        PatientUser pu1 = new PatientUser("patient1", "patient1", "123456", "3553454", Constants.PATIENT_ID, new Date(), "ic_launcher_foreground");
        PatientUser pu2 = new PatientUser("patient2", "patient2", "123456", "3553454", Constants.PATIENT_ID, new Date(), "ic_launcher_foreground");
        PatientUser pu3 = new PatientUser("patient3", "patient3", "123456", "3553454", Constants.PATIENT_ID, new Date(), "ic_launcher_foreground");
        PatientUser pu4 = new PatientUser("patient4", "patient4", "123456", "3553454", Constants.PATIENT_ID, new Date(), "ic_launcher_foreground");
        PatientUser pu5 = new PatientUser("patient5", "patient5", "123456", "3553454", Constants.PATIENT_ID, new Date(), "ic_launcher_foreground");

        StudentUser su1 = new StudentUser("student1", "student1", "123456", "3553454", Constants.STUDENT_ID, new Date(), "ic_launcher_foreground");
        StudentUser su2 = new StudentUser("student2", "student2", "123456", "3553454", Constants.STUDENT_ID, new Date(), "ic_launcher_foreground");
        StudentUser su3 = new StudentUser("student3", "student3", "123456", "3553454", Constants.STUDENT_ID, new Date(), "ic_launcher_foreground");
        StudentUser su4 = new StudentUser("student4", "student4", "123456", "3553454", Constants.STUDENT_ID, new Date(), "ic_launcher_foreground");
        StudentUser su5 = new StudentUser("student5", "student5", "123456", "3553454", Constants.STUDENT_ID, new Date(), "ic_launcher_foreground");


        DoctorUser du1 = new DoctorUser("doctor1", "doctor1", "123456", "3553454", Constants.DOCTOR_ID, new Date(), "ic_launcher_foreground");
        DoctorUser du2 = new DoctorUser("doctor2", "doctor2", "123456", "3553454", Constants.DOCTOR_ID, new Date(), "ic_launcher_foreground");
        DoctorUser du3 = new DoctorUser("doctor3", "doctor3", "123456", "3553454", Constants.DOCTOR_ID, new Date(), "ic_launcher_foreground");
        DoctorUser du4 = new DoctorUser("doctor4", "doctor4", "123456", "3553454", Constants.DOCTOR_ID, new Date(), "ic_launcher_foreground");
        DoctorUser du5 = new DoctorUser("doctor5", "doctor5", "123456", "3553454", Constants.DOCTOR_ID, new Date(), "ic_launcher_foreground");

        FoundationUser fu1 = new FoundationUser("foundation1", "foundation1", "123456", "3553454", Constants.FOUNDATION_ID, new Date(), "ic_launcher_foreground");
        FoundationUser fu2 = new FoundationUser("foundation2", "foundation2", "123456", "3553454", Constants.FOUNDATION_ID, new Date(), "ic_launcher_foreground");
        FoundationUser fu3 = new FoundationUser("foundation3", "foundation3", "123456", "3553454", Constants.FOUNDATION_ID, new Date(), "ic_launcher_foreground");
        FoundationUser fu4 = new FoundationUser("foundation4", "foundation4", "123456", "3553454", Constants.FOUNDATION_ID, new Date(), "ic_launcher_foreground");
        FoundationUser fu5 = new FoundationUser("foundation5", "foundation5", "123456", "3553454", Constants.FOUNDATION_ID, new Date(), "ic_launcher_foreground");


        MedicineGroup mg1 = new MedicineGroup("group1");
        MedicineGroup mg2 = new MedicineGroup("group2");
        MedicineGroup mg3 = new MedicineGroup("group3");
        MedicineGroup mg4 = new MedicineGroup("group4");
        MedicineGroup mg5 = new MedicineGroup("group5");

        MedicineDepartment md1 = new MedicineDepartment("department1");
        MedicineDepartment md2 = new MedicineDepartment("department2");
        MedicineDepartment md3 = new MedicineDepartment("department3");
        MedicineDepartment md4 = new MedicineDepartment("department4");
        MedicineDepartment md5 = new MedicineDepartment("department5");

        Medicine m1 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg1, md1);
        m1.getTraditionalNames().add("Tradition name1");
        m1.getTraditionalNames().add("Tradition name2");
        m1.getTraditionalNames().add("Tradition name3");
        m1.getTraditionalNames().add("Tradition name4");
        m1.getTraditionalNames().add("Tradition name5");
        m1.setSideEffect("Side Effect fkls jfd nfnf " +
                "jnef fnk jenffkj ewfefn jkew " +
                "fbkqbff nefbk jewbfn fwekfj");
        m1.setAbout("About Medicine Number 1 About Medicine Number 1" +
                " About Medicine Number 1 About Medicine Number 1 ");
        m1.setUses("This Will Take For You How Can Use this Medicine In Correct Way ." +
                "This Will Take For You How Can Use this Medicine In Correct Way ." +
                "This Will Take For You How Can Use this Medicine In Correct Way .");
        m1.setStorage("This Will Take For You How Can Strorge this Medicine In Correct Way to Save Medicine.");
        Medicine m2 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg1, md1);
        Medicine m3 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg1, md1);
        Medicine m4 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg1, md1);
        Medicine m5 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg1, md1);


        pu1.getMedicines().add(m1);
        pu1.getMedicines().add(m2);
        pu1.getMedicines().add(m3);
        pu1.getMedicines().add(m4);
        pu1.getMedicines().add(m5);



        pu2.getMedicines().add(m1);
        pu2.getMedicines().add(m2);
        pu2.getMedicines().add(m3);
        pu2.getMedicines().add(m4);
        pu3.getMedicines().add(m5);



        pu4.getMedicines().add(m1);
        pu3.getMedicines().add(m2);
        pu2.getMedicines().add(m3);
        pu1.getMedicines().add(m4);
        pu5.getMedicines().add(m5);



        pu5.getMedicines().add(m1);
        pu4.getMedicines().add(m2);
        pu5.getMedicines().add(m3);
        pu4.getMedicines().add(m4);
        pu3.getMedicines().add(m5);


        pu4.getMedicines().add(m1);
        pu4.getMedicines().add(m2);
        pu3.getMedicines().add(m3);
        pu2.getMedicines().add(m4);
        pu3.getMedicines().add(m5);

        Medicine m11 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg1, md2);
        Medicine m22 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg1, md2);
        Medicine m33 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg1, md2);
        Medicine m44 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg1, md2);
        Medicine m55 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg1, md2);

        Medicine m111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg1, md3);
        Medicine m222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg1, md3);
        Medicine m333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg1, md3);
        Medicine m444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg1, md3);
        Medicine m555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg1, md3);


        Medicine m1111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg1, md4);
        Medicine m2222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg1, md4);
        Medicine m3333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg1, md4);
        Medicine m4444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg1, md4);
        Medicine m5555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg1, md4);


        Medicine m11111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg1, md5);
        Medicine m22222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg1, md5);
        Medicine m33333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg1, md5);
        Medicine m44444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg1, md5);
        Medicine m55555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg1, md5);


        Medicine mm1 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg2, md1);
        Medicine mm2 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg2, md1);
        Medicine mm3 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg2, md1);
        Medicine mm4 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg2, md1);
        Medicine mm5 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg2, md1);


        Medicine mm11 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg2, md2);
        Medicine mm22 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg2, md2);
        Medicine mm33 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg2, md2);
        Medicine mm44 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg2, md2);
        Medicine mm55 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg2, md2);

        Medicine mm111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg2, md3);
        Medicine mm222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg2, md3);
        Medicine mm333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg2, md3);
        Medicine mm444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg2, md3);
        Medicine mm555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg2, md3);


        Medicine mm1111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg2, md4);
        Medicine mm2222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg2, md4);
        Medicine mm3333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg2, md4);
        Medicine mm4444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg2, md4);
        Medicine mm5555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg2, md4);


        Medicine mm11111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg2, md5);
        Medicine mm22222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg2, md5);
        Medicine mm33333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg2, md5);
        Medicine mm44444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg2, md5);
        Medicine mm55555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg2, md5);


        Medicine mmm1 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg3, md1);
        Medicine mmm2 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg3, md1);
        Medicine mmm3 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg3, md1);
        Medicine mmm4 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg3, md1);
        Medicine mmm5 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg3, md1);


        Medicine mmm11 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg3, md2);
        Medicine mmm22 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg3, md2);
        Medicine mmm33 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg3, md2);
        Medicine mmm44 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg3, md2);
        Medicine mmm55 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg3, md2);

        Medicine mmm111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg3, md3);
        Medicine mmm222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg3, md3);
        Medicine mmm333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg3, md3);
        Medicine mmm444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg3, md3);
        Medicine mmm555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg3, md3);


        Medicine mmm1111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg3, md4);
        Medicine mmm2222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg3, md4);
        Medicine mmm3333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg3, md4);
        Medicine mmm4444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg3, md4);
        Medicine mmm5555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg3, md4);


        Medicine mmm11111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg3, md5);
        Medicine mmm22222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg3, md5);
        Medicine mmm33333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg3, md5);
        Medicine mmm44444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg3, md5);
        Medicine mmm55555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg3, md5);


        Medicine mmmm1 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg4, md1);
        Medicine mmmm2 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg4, md1);
        Medicine mmmm3 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg4, md1);
        Medicine mmmm4 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg4, md1);
        Medicine mmmm5 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg4, md1);


        Medicine mmmm11 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg4, md2);
        Medicine mmmm22 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg4, md2);
        Medicine mmmm33 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg4, md2);
        Medicine mmmm44 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg4, md2);
        Medicine mmmm55 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg4, md2);

        Medicine mmmm111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg4, md3);
        Medicine mmmm222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg4, md3);
        Medicine mmmm333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg4, md3);
        Medicine mmmm444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg4, md3);
        Medicine mmmm555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg4, md3);


        Medicine mmmm1111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg4, md4);
        Medicine mmmm2222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg4, md4);
        Medicine mmmm3333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg4, md4);
        Medicine mmmm4444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg4, md4);
        Medicine mmmm5555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg4, md4);


        Medicine mmmm11111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg4, md5);
        Medicine mmmm22222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg4, md5);
        Medicine mmmm33333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg4, md5);
        Medicine mmmm44444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg4, md5);
        Medicine mmmm55555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg4, md5);


        Medicine mmmmm1 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg5, md1);
        Medicine mmmmm2 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg5, md1);
        Medicine mmmmm3 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg5, md1);
        Medicine mmmmm4 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg5, md1);
        Medicine mmmmm5 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg5, md1);


        Medicine mmmmm11 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg5, md2);
        Medicine mmmmm22 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg5, md2);
        Medicine mmmmm33 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg5, md2);
        Medicine mmmmm44 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg5, md2);
        Medicine mmmmm55 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg5, md2);

        Medicine mmmmm111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg5, md3);
        Medicine mmmmm222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg5, md3);
        Medicine mmmmm333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg5, md3);
        Medicine mmmmm444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg5, md3);
        Medicine mmmmm555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg5, md3);


        Medicine mmmmm1111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg5, md4);
        Medicine mmmmm2222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg5, md4);
        Medicine mmmmm3333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg5, md4);
        Medicine mmmmm4444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg5, md4);
        Medicine mmmmm5555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg5, md4);


        Medicine mmmmm11111 = new Medicine("medicine1", "about1", "uses1", "side effect1", mg5, md5);
        Medicine mmmmm22222 = new Medicine("medicine2", "about2", "uses2", "side effect2", mg5, md5);
        Medicine mmmmm33333 = new Medicine("medicine3", "about3", "uses3", "side effect3", mg5, md5);
        Medicine mmmmm44444 = new Medicine("medicine4", "about4", "uses4", "side effect4", mg5, md5);
        Medicine mmmmm55555 = new Medicine("medicine5", "about5", "uses5", "side effect5", mg5, md5);

    }
}
