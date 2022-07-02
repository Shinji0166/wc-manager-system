package cn.com.wudskq.vo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author chenfangchao
 * @title: Response
 * @projectName wc-manager-system
 * @description: TODO Response模型
 * @date 2022/6/23 10:56 AM
 */
@Data
@Accessors(chain = true)
public class Response {

    @ApiModelProperty(value = "返回码")
    private int code;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    @ApiModelProperty(value = "返回描述")
    private String msg;

    @ApiModelProperty(value = "返回长度")
    private long count;

    /**
     * 返回成功
     */
    public static Response success(List<Object> data, long count) {
        Response response = new Response();
        response.setCode(200);//成功
        response.setMsg("成功");//提示语
        response.setData(data);
        response.setCount(count);
        return response;
    }

    /**
     * 返回成功
     */
    public static Response success(List data) {
        Response response = new Response();
        response.setCode(200);//成功
        response.setMsg("成功");//提示语
        response.setData(data);
        response.setCount(data == null || data.size() == 0 ? 0 : data.size());
        return response;
    }

    /**
     * 返回成功
     */
    public static Response successForPage(List data, Integer count) {
        Response response = new Response();
        response.setCode(200);//成功
        response.setMsg("成功");//提示语
        response.setData(data);
        response.setCount(count == null ? 0 : count);
        return response;
    }

    /**
     * 返回成功
     */
    public static Response success() {
        Response response = new Response();
        response.setCode(200);//成功
        response.setMsg("成功");//提示语
        return response;
    }

    /**
     * 返回成功
     */
    public static Response success(Object object) {
        Response response = new Response();
        response.setCode(200);//成功
        response.setMsg("成功");//提示语
        response.setData(object);//返回内容
        return response;
    }

    /**
     * 返回失败
     */
    public static Response error() {
        Response response = new Response();
        response.setCode(500);//失败
        response.setMsg("失败");//提示语
        return response;
    }

    /**
     * 返回失败
     */
    public static Response error(int code, String msg) {
        Response response = new Response();
        response.setCode(code);//失败
        response.setMsg(msg);//提示语
        return response;
    }

    /**
     * 返回信息
     */
    public static Response response(int code, String msg, Object data) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    /**
     * Response输出Json格式
     */
    public static void responseJson(ServletResponse response, Object data) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(data));
            out.flush();
        } catch (Exception e) {
            System.out.println("Response输出Json异常：" + e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}