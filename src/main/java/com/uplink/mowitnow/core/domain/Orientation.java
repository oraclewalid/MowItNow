package com.uplink.mowitnow.core.domain;

/**
 * Created by walid on 12/09/14.
 */
public enum Orientation {
    N {
        public Orientation getOrientation(Instruction rotation){

            switch (rotation){
                case D:
                    return E;
                case G:
                    return W;
            }
            return null;
        }
    },
    E {
        public Orientation getOrientation(Instruction rotation){

            switch (rotation){
                case D:
                    return S;
                case G:
                    return N;
            }
            return null;
        }
    }
    ,
    W {
        public Orientation getOrientation(Instruction rotation){

            switch (rotation){
                case D:
                    return N;
                case G:
                    return S;
            }
            return null;
        }
    }
    ,
    S {
        public Orientation getOrientation(Instruction rotation){

            switch (rotation){
                case D:
                    return W;
                case G:
                    return E;
            }
            return null;
        }
    };


    public abstract Orientation getOrientation(Instruction rotation);
}
