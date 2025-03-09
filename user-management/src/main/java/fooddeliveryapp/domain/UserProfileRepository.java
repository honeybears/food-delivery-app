package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "userProfiles",
    path = "userProfiles"
)
public interface UserProfileRepository
    extends PagingAndSortingRepository<UserProfile, String> {}
