package pl.slusarski.top10listappbackend.exception;

public class ListNotFoundExceptionResponse {

    private String listNotFound;

    public ListNotFoundExceptionResponse(String listNotFound) {
        this.listNotFound = listNotFound;
    }

    public String getListNotFound() {
        return listNotFound;
    }

    public void setListNotFound(String listNotFound) {
        this.listNotFound = listNotFound;
    }
}
