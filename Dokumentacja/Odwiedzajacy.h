#include <exception>
using namespace std;

#ifndef __Odwiedzający_h__
#define __Odwiedzający_h__

// #include "Klient.h"

class Klient;
class Odwiedzajacy;

/**
 * osoba posiadająca możliwość korzystania z podstawowych funkcjonalności sklepu.
 */
class Odwiedzający
{
	private: string _klient;
	public: Klient* _unnamed_Klient_;

	public: void możliwosc_przegladania_strony();
};

#endif
