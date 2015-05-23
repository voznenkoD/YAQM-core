package org.perspectiveJuniors.YAQM.entity;

import javax.persistence.*;

/**
 * Created by Всеволод on 12.04.2015.
 */
@Entity
@Table(name="QUEUE")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="QUEUE_TYPE",
        discriminatorType= DiscriminatorType.STRING
)
public abstract class AbstractQueue {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="QUEUE_ID")
    protected long id;

    public abstract long getId();
}
