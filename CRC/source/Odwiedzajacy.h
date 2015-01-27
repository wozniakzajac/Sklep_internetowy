#include <exception>
using namespace std;

#ifndef __Odwiedzaj¹cy_h__
#define __Odwiedzaj¹cy_h__

// #include "Klient.h"

class Klient;
class Odwiedzajacy;

/**
 * osoba posiadaj¹ca mo¿liwoœæ korzystania z podstawowych funkcjonalnoœci sklepu.
 */
class Odwiedzaj¹cy
{
	private: string _klient;
	public: Klient* _unnamed_Klient_;

	public: void mo¿liwosc_przegladania_strony();
};

#endif
