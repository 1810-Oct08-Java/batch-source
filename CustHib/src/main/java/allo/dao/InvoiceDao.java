package allo.dao;

import java.util.List;

import allo.model.*;


public interface InvoiceDao {

List<Invoice> getInvoices ();

Invoice getInvoiceById (int id);

int createInvoice (Invoice i);

void updateInvoice (Invoice i);

void deleteInvoiceById (int id);



}
