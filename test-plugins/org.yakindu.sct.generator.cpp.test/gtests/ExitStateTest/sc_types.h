
#ifndef SC_TYPES_H_
#define SC_TYPES_H_

/* As <cstdint> is not available on all platforms we choose to include <stdint.h>. You can switch to <cstdint> by commenting and uncommenting the lines below.*/
// #include <cstdint>
#include <stdint.h>


#define sc_string      char*

typedef int_fast16_t   sc_short;
typedef uint_fast16_t  sc_ushort;
typedef int32_t        sc_integer;
typedef double         sc_real;
typedef bool           sc_boolean;

typedef intptr_t       sc_eventid;

#ifndef null
	#define null 0
#endif

#endif /* SC_TYPES_H_ */
