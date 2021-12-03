package org.example.repository;
import org.example.entity.Transfer;

import java.util.List;

public interface TransferRepository {
    void save(Transfer transfer);
    List<Transfer> findAll(String filter);
    Transfer findById(int id);

}
