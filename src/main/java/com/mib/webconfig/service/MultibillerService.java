package com.mib.webconfig.service;

import com.mib.webconfig.entity.Movie;
import com.mib.webconfig.entity.Multibiller;

import java.util.List;

public interface MultibillerService {

    List<Multibiller> showAll();

    Multibiller create(Multibiller multibiller);

    Multibiller update(String name, Multibiller multibiller);

    void delete(String name);

    Multibiller findByName(String name);
}
