package com.example.foodtrove0.wishlist;
import com.example.foodtrove0.common.repository.GenericRepository;
import com.example.foodtrove0.wishlist.entity.Wishlist;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface WishlistRepository extends GenericRepository<Wishlist, UUID> {

}
