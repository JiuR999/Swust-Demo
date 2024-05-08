package cn.swust.springdemo.pojo;

import lombok.Data;

@Data
public class Result {
    int code;
    String msg;
    Object data;
    public static Result success(Object obj){
        return new Result(200,"success",obj);
    }

    public static Result success(){
        return new Result(200,"success",null);
    }
    public static Result error(String msg){
        return new Result(404,msg,null
        );
    }
    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
