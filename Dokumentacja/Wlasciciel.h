#include <exception>
using namespace std;

#ifndef __W³aœciciel_h__
#define __W³aœciciel_h__

// #include "Sklep.h"
// #include "Produkt.h"

class Sklep;
class Produkt;
class Wlasciciel;

/**
 * dodaje/usuwa nowe produkty
 */
class Wlasciciel
{
	private: string _produkt;
	private: string _sklep;
	public: Sklep* _unnamed_Sklep_;
	public: Produkt* _unnamed_Produkt_;

	public: void przechowuje_informacje_o_dodawanych_usuwanych_przez_wlasciciela_produktach();
};

#endif
