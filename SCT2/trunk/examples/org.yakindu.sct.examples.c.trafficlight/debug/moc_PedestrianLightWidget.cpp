/****************************************************************************
** Meta object code from reading C++ file 'PedestrianLightWidget.h'
**
** Created: Fri Oct 19 14:59:25 2012
**      by: The Qt Meta Object Compiler version 63 (Qt 4.8.1)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../widgets/PedestrianLightWidget.h"
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'PedestrianLightWidget.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 63
#error "This file was generated using the moc from 4.8.1. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
static const uint qt_meta_data_PedestrianLightWidget[] = {

 // content:
       6,       // revision
       0,       // classname
       0,    0, // classinfo
       1,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: signature, parameters, type, tag, flags
      39,   23,   22,   22, 0x0a,

       0        // eod
};

static const char qt_meta_stringdata_PedestrianLightWidget[] = {
    "PedestrianLightWidget\0\0white,red,green\0"
    "setSignals(bool,bool,bool)\0"
};

void PedestrianLightWidget::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        Q_ASSERT(staticMetaObject.cast(_o));
        PedestrianLightWidget *_t = static_cast<PedestrianLightWidget *>(_o);
        switch (_id) {
        case 0: _t->setSignals((*reinterpret_cast< bool(*)>(_a[1])),(*reinterpret_cast< bool(*)>(_a[2])),(*reinterpret_cast< bool(*)>(_a[3]))); break;
        default: ;
        }
    }
}

const QMetaObjectExtraData PedestrianLightWidget::staticMetaObjectExtraData = {
    0,  qt_static_metacall 
};

const QMetaObject PedestrianLightWidget::staticMetaObject = {
    { &QWidget::staticMetaObject, qt_meta_stringdata_PedestrianLightWidget,
      qt_meta_data_PedestrianLightWidget, &staticMetaObjectExtraData }
};

#ifdef Q_NO_DATA_RELOCATION
const QMetaObject &PedestrianLightWidget::getStaticMetaObject() { return staticMetaObject; }
#endif //Q_NO_DATA_RELOCATION

const QMetaObject *PedestrianLightWidget::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->metaObject : &staticMetaObject;
}

void *PedestrianLightWidget::qt_metacast(const char *_clname)
{
    if (!_clname) return 0;
    if (!strcmp(_clname, qt_meta_stringdata_PedestrianLightWidget))
        return static_cast<void*>(const_cast< PedestrianLightWidget*>(this));
    return QWidget::qt_metacast(_clname);
}

int PedestrianLightWidget::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QWidget::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 1)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 1;
    }
    return _id;
}
QT_END_MOC_NAMESPACE
