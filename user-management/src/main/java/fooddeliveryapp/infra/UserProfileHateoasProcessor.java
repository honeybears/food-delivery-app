package fooddeliveryapp.infra;

import fooddeliveryapp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserProfileHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<UserProfile>> {

    @Override
    public EntityModel<UserProfile> process(EntityModel<UserProfile> model) {
        return model;
    }
}
