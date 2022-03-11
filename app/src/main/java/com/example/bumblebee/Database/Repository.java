package com.example.bumblebee.Database;

import android.app.Application;

import com.example.bumblebee.DAO.PartDAO;
import com.example.bumblebee.DAO.ProductDAO;
import com.example.bumblebee.Entity.Part;
import com.example.bumblebee.Entity.Product;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private PartDAO mPartDAO;
    private ProductDAO mProductDAO;
    private List<Part> mAllParts;
    private List<Product> mAllProducts;

    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        BicycleDatabaseBuilder db = BicycleDatabaseBuilder.getDatabase(application);
        mPartDAO = db.partDAO();
        mProductDAO = db.productDAO();
    }

    public void insert(Product product) {
        databaseExecutor.execute(() -> {
            mProductDAO.insert(product);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        databaseExecutor.execute(() -> {
            mAllProducts = mProductDAO.getAllProducts();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return mAllProducts;
    }

    public void update(Product product) {
        databaseExecutor.execute(() -> {
            mProductDAO.update(product);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Product product) {
        databaseExecutor.execute(() -> {
            mProductDAO.delete(product);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void insert(Part part) {
        databaseExecutor.execute(() -> {
            mPartDAO.insert(part);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public List<Part> getAllParts() {
        databaseExecutor.execute(() -> {
            mAllParts = mPartDAO.getAllParts();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return mAllParts;
    }

    public void update(Part part) {
        databaseExecutor.execute(() -> {
            mPartDAO.update(part);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Part part) {
        databaseExecutor.execute(() -> {
            mPartDAO.delete(part);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
