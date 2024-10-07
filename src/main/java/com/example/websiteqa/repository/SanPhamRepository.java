package com.example.websiteqa.repository;

import com.example.websiteqa.entity.SanphamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanphamEntity, Integer> {
    @Query(value = "SELECT sp FROM SanphamEntity sp, LoaisanphamEntity l WHERE sp.loaisanphamEntity.id = l.id and l.duongdan = ?1 ORDER BY sp.id")
    Page<SanphamEntity> findAllByMetatitle(String metatitle, Pageable pageable);
    @Query(value = "SELECT sp FROM SanphamEntity sp, LoaisanphamEntity l WHERE sp.loaisanphamEntity.id = l.id and l.duongdan = ?1 ORDER BY sp.id")
    List<SanphamEntity> findAllByMetatitle(String metatitle);
    @Query(value = "SELECT sp FROM SanphamEntity sp, NhanhieuEntity h WHERE sp.nhanhieuEntity.id = h.id and h.duongdan = ?1 ORDER BY sp.id")
    Page<SanphamEntity> findAllByBrand(String metatitle, Pageable pageable);
    @Query(value = "SELECT sp FROM SanphamEntity sp, NhanhieuEntity h WHERE sp.nhanhieuEntity.id = h.id and h.duongdan = ?1 ORDER BY sp.id")
    List<SanphamEntity> findAllByBrand(String metatitle);
    @Query(value = "SELECT sp FROM SanphamEntity sp WHERE sp.ten LIKE ?1 ORDER BY sp.id")
    Page<SanphamEntity> search(String key, Pageable pageable);
    @Query(value = "SELECT sp FROM SanphamEntity sp WHERE sp.ten LIKE ?1 ORDER BY sp.id")
    List<SanphamEntity> search(String key);
}
