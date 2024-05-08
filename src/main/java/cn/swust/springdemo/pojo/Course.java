package cn.swust.springdemo.pojo;

import cn.swust.springdemo.validation.OnEdit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @NotNull(groups = OnEdit.class, message = "课程id不能为空")
    @Positive
    @Id
    @Column(name = "id")
    Long id;
    @NotNull(message = "课程代码不能为空")
    @Pattern(regexp = "[a-z|0-9]*", message = "课程代码只能为字母或数字")
    String code;
    @NotBlank(message = "课程名不能为空")
    @Size(min = 4, max = 16, message = "名称长度必须在4-16")
    String name;

    long collegeId;

}
