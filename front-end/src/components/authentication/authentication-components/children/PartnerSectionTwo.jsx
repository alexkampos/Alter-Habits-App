import React from 'react';
import { useDropzone } from 'react-dropzone';

export default function PartnerSectionTwo(props){

    const { getRootProps, getInputProps } = useDropzone({
        accept: "image/*",
        onDrop: (acceptedFiles) => {
            props.setFiles(
                acceptedFiles.map((file) => (
                    Object.assign(file, {
                        preview: URL.createObjectURL(file)
                    })
                ))
            )
        }
    })

    const image = props.files.map((file) => (
        <div key={file && file.name}>
            <div>
                <img src={file && file.preview} style={{ height: "170px" }} alt="uploaded photo" />
            </div>
        </div>
    ))

    return (
        <div className="activities-selection-container">
            <div {...getRootProps()} className="image-dropzone">
                <input {...getInputProps()} />
                <p>Drop shop's image here.</p>
            </div>
            <div className="preview-image-container">{image}</div>
        </div>
    )
}