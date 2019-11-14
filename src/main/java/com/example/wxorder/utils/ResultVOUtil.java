package com.example.wxorder.utils;

import com.example.wxorder.vo.ResultVo;

/**
 * @author 李清依
 * @version 1.0
 * @date 2019/11/14 19:39
 */
public class ResultVOUtil {
    public static ResultVo success(Object object){
        ResultVo resultVO=new ResultVo();
        resultVO.setCode(0);
        resultVO.setData(object);
        resultVO.setMsg("成功");
        return resultVO;
    }
    public static ResultVo success(){
        return success(null);
    }
    public static ResultVo error(Integer code,String msg){
        ResultVo resultVO = new ResultVo();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }

}
