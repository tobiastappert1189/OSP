package Server.Repository;

import java.util.List;

import Server.Pojo.Tour;

public interface TourRepository
{
    Tour createTour(Tour tour);

    Tour getTour(int id);

    List<Tour> getTours();

    void updateTour(Tour user);

    void deleteTour(int id);
}
