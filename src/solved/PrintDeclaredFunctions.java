package solved;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

class Student3{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anotherfunction(){  }

    public void dnqvo(){  }
    public void bwkbd(){  }
    public void rmjig(){  }
    public void amftc(){  }
    public void kgwku(){  }
    public void ogvdl(){  }
    public void viyog(){  }
    public void pqfct(){  }
    public void iwhtf(){  }
    public void ptrup(){  }
    public void viwuu(){  }
    public void tkbpp(){  }
    public void plaob(){  }
    public void ghtlj(){  }
    public void pvgyp(){  }
    public void ormim(){  }
    public void cfwyc(){  }
    public void sumvl(){  }
    public void elyed(){  }
    public void cmkxa(){  }
    public void toxdp(){  }
    public void qthde(){  }
    public void whjtj(){  }
    public void moebl(){  }
    public void piwro(){  }
    public void atcks(){  }
    public void ehjdm(){  }
    public void ytijy(){  }
    public void migyc(){  }
    public void pnruo(){  }
    public void fmyce(){  }
    public void odyqp(){  }
    public void twyfa(){  }
    public void levtp(){  }
    public void ujxei(){  }
    public void dvvwq(){  }
    public void mcgme(){  }
    public void kbjlt(){  }
    public void ahqym(){  }
    public void tntpj(){  }
    public void jnskt(){  }
    public void dnpym(){  }
    public void jmopy(){  }
    public void uccfq(){  }
    public void vhxoi(){  }
    public void nixhb(){  }
    public void isqdf(){  }
    public void khuag(){  }
    public void hluvb(){  }



}

public class PrintDeclaredFunctions {

    public static void main(String[] args){
        Student3 student = new Student3();
        Method[] methods = student.getClass().getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(int i = 0; i < methods.length; i++){
            methodList.add(methods[i].getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }

}