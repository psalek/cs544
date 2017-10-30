package cs544.sample;

import java.util.List;

public interface ICarDao {

	public abstract List<Car> getAll();

	public abstract void add(Car car);

	public abstract Car get(int id);

	public abstract void update(int carId, Car car);

	public abstract void delete(int carId);

}