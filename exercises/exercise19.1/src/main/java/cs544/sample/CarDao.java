package cs544.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDao implements ICarDao {
	private static int idCount = 1;
	private Map<Integer, Car> cars = new HashMap<>();
	
	public CarDao() {
		add(new Car("Volvo", "S80", 1999, "Silver"));
		add(new Car("Honda", "Accord", 1997, "Red"));
	}
	
	@Override
	public List<Car> getAll() {
		return new ArrayList<Car>(cars.values());
	}
	
	@Override
	public void add(Car car) {
		car.setId(idCount);
		cars.put(idCount, car);
		idCount++;
	}
	
	@Override
	public Car get(int id) {
		Car result = cars.get(id);
		
		if (result == null) {
			throw new NoSuchResourceException("Car", id);
		}
		
		return result;
	}
	
	@Override
	public void update(int carId, Car car) {
		cars.put(carId, car);
	}
	
	@Override
	public void delete(int carId) {
		Car removed = cars.remove(carId);
		if (removed == null) {
			throw new NoSuchResourceException("Car", carId);
		}
	}
}
