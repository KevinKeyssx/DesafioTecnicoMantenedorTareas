import { Moment } from "moment";

export interface ITarea {
    identificador   : number;
    descripcion     : string;
    fechaCreacion   : Moment;
    vigente         : boolean;
    type?           : string;
}

export interface IMap {
    key             : string;   
    value           : string;
}
