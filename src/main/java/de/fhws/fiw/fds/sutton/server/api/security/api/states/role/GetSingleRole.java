package de.fhws.fiw.fds.sutton.server.api.security.api.states.role;

import de.fhws.fiw.fds.sutton.server.api.security.database.dao.IAuthDaoSupplier;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetState;
import de.fhws.fiw.fds.sutton.server.api.security.models.Role;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;

public class GetSingleRole extends AbstractGetState<Role>
        implements IAuthDaoSupplier {

    public GetSingleRole(AbstractGetStateBuilder builder) {
        super(builder);
    }

    @Override
    protected SingleModelResult<Role> loadModel() {
        return getRoleDao().readById(requestedId);
    }

    @Override
    protected void authorizeRequest() {
    }

    @Override
    protected void defineTransitionLinks() {
        addLink(RoleUri.REL_PATH_ID, RoleRelTypes.UPDATE_SINGLE_ROLE, getAcceptRequestHeader(),
                this.requestedId);
        addLink(RoleUri.REL_PATH_ID, RoleRelTypes.DELETE_SINGLE_ROLE, getAcceptRequestHeader(),
                this.requestedId);
    }

    public static class GetRoleStateBuilder extends AbstractGetStateBuilder {
        @Override
        public GetSingleRole build() {
            return new GetSingleRole(this);
        }
    }
}
