package cn.swust.springdemo.pojo;

import cn.swust.springdemo.validation.OnCreate;
import cn.swust.springdemo.validation.OnEdit;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @NotNull(groups = OnEdit.class,message = "学生ID不能为空")
    @Positive
    private long id;
    @Pattern(regexp = "^2\\d{7}$", message="学号为2开头的8位数字")
    private String no;
    @NotBlank
    @Size(min=1,max=10,message = "姓的长度只能在1-10")
    private String firstname;
    @NotBlank
    @Size(min=1,max=10,message = "名的长度只能在1-10")
    private String lastname;
    @NotNull
    @Pattern(regexp="^M|F$", message="性别只能是M或者F")
    private String gender;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @Email
    private String email;
    public Student(long id, String no, String firstname, String lastname, String gender) {
        this.id = id;
        this.no = no;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    public Student(String no, String firstname, String lastname, String gender, LocalDate birthday) {
        this.no = no;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
    }
}
