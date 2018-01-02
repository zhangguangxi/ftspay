package com.fx.common.exception;

import com.fx.common.bean.result.WxError;
import lombok.Builder;
import lombok.Data;

/**
 * Created by JONES on 2017/12/28.
 */
@Data
@Builder
public class WxErrorException extends Exception {
    private static final long serialVersionUID = -6357149550353160810L;

    private WxError error;

    public WxErrorException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxErrorException(WxError error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }

    public WxError getError() {
        return this.error;
    }
}
