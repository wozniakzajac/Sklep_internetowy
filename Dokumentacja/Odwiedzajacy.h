#include <exception>
using namespace std;

#ifndef __Odwiedzaj�cy_h__
#define __Odwiedzaj�cy_h__

// #include "Klient.h"

class Klient;
class Odwiedzajacy;

/**
 * osoba posiadaj�ca mo�liwo�� korzystania z podstawowych funkcjonalno�ci sklepu.
 */
class Odwiedzaj�cy
{
	private: string _klient;
	public: Klient* _unnamed_Klient_;

	public: void mo�liwosc_przegladania_strony();
};

#endif
