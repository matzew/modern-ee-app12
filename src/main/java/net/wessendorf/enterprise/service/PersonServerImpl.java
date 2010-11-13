/*
 * Copyright (C) 2010 Matthias Weßendorf.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.wessendorf.enterprise.service;

import java.util.List;

import javax.inject.Inject;

import net.wessendorf.enterprise.beans.Person;
import net.wessendorf.enterprise.jpa.dao.PersonDao;

public class PersonServerImpl implements PersonService
{

  @Inject
  private PersonDao dao;

  public void removePerson(Person person)
  {
    dao.delete(person);
  }

  public Person savePerson(Person person)
  {
    return dao.persist(person);
  }

  public Person updatePerson(Person person)
  {
    return dao.update(person);
  }
  
  public List<Person> findAllPersons()
  {
    return dao.loadAll();
  }

  public Person findPersonById(String id)
  {
    return dao.loadById(id);
  }

  public List<Person> findPersonsByLastName(String lastName)
  {
    return dao.findByLastName(lastName);
  }
}
