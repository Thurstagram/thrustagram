package umc.thurstagram.apipayload.Handler;

import umc.thurstagram.apipayload.code.BaseCode;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseCode errorCode) {
        super((ErrorStatus) errorCode);
    }
}