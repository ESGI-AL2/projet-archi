package use_case;

import infrastructure.dao.IChoiceDao;
import infrastructure.factories.DaoFactory;

public class DeleteChoicesUseCase {
    private void delete() {
        IChoiceDao choiceDao = DaoFactory.getChoiceDao();
        choiceDao.deleteAll();
    }
    public DeleteChoicesUseCase () {
        delete();
    }
}
