package org.example.service;

import org.example.exception.CheckedException;

public interface UserService {


    void saveCheckedException() throws CheckedException;
    void saveCheckedExceptionWithRollbackFor() throws CheckedException;
    void saveRuntimeException();
    void saveTwoTransactionRuntime();
    void saveTwoTransactionRuntimeCatch();
}
